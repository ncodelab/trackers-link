import java.util.Date

import com.ncodelab.trackers.bitbucket._
import org.scalatest._

class BitbucketSpec extends FlatSpec with Matchers {
  val token: Auth.Token = Auth.auth(Credentials("EuDgee", "jEMpqrFnQzpPv7zrBbk3K"))
  val repo = Repository("EuDgee", "issue-checks")

  "Bitbucket API" should "be able to create, list, modify and delete issues" in {
    val bb = new Bitbucket(token, repo)
    val before = bb.loadIssues()

    val issue: Issue = Issue(
      Option.empty,
      Priority.minor,
      Kind.enhancement,
      "Test Title",
      IssueState.New,
      null,
      null,
      IssueContent.md("# Issue Content Test\n\n- one\n- two\n- *three*\n"),
      new Date(),
      new Date(),
      new Date()
    )

    val dataCreated = bb.createIssue(issue)
    dataCreated shouldBe defined
    dataCreated.get.id shouldBe defined
    val issueCreated = dataCreated.get

    val issues = bb.loadIssues()
    issues.size should equal (before.size + 1)
    issues.map(_.title) should contain (issueCreated.title)
    issues.map(_.content.raw) should contain (issueCreated.content.raw)
    issues.map(_.reporter).filter(_ != null) should not be empty
    issues.map(_.assignee).filter(_ != null) shouldBe empty

    val issueM: Issue = Issue(
      issueCreated.id,
      Priority.minor,
      Kind.enhancement,
      "Test Title",
      IssueState.New,
      null,
      null,
      IssueContent.md("# Issue Content Test\n\n- one\n- two\n- *three*\n- **four**\n"),
      new Date(),
      new Date(),
      new Date()
    )

    val issueModified = bb.modifyIssue(issueM)
//    dataModified shouldBe defined
//    val issueModified = dataModified.get
    issueModified.id should equal (issueCreated.id)
    issueModified.title should equal (issueCreated.title)

    val issuesAfterModification = bb.loadIssues()
    issuesAfterModification.map(_.content.raw) should contain (issueModified.content.raw)
    issuesAfterModification.map(_.content.raw) should not contain issueCreated.content.raw

    bb.deleteIssue(issueModified.id.get.toString) should equal (true)
    bb.loadIssues().size should equal (before.size)
  }
}
