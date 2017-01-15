package com.ncodelab.trackers

import java.util.Date

import com.ncodelab.trackers.bitbucket._

object Main extends App {
  val token: Auth.Token = Auth.auth(Credentials("EuDgee", "jEMpqrFnQzpPv7zrBbk3K"))
  val repo = Repository("EuDgee", "issue-checks")
  val bb = new Bitbucket(token, repo)
  println(bb.loadIssues())

  val issue: Issue = Issue(
    Priority.minor,
    Kind.enhancement,
    "Test Title",
    IssueState.New,
    null,
    null,
    IssueContent("Issue Content Test", "", ""),
    new Date(),
    new Date(),
    new Date()
  )

  println(issue.toPostData)
  println(bb.createIssue(issue))
  println(bb.loadIssues())
}
