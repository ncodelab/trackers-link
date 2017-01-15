package com.ncodelab.trackers.bitbucket

import com.ncodelab.trackers.Json
import com.ncodelab.trackers.bitbucket.Auth.Token

import scalaj.http._

class Bitbucket(val token: Token, val repo: Repository) {
  val URL: String = "https://api.bitbucket.org/2.0/repositories"

  type IssueId = String

  def loadIssues(): List[Issue] =
    Json.fromJson[LoadedIssues](Http(s"$URL/${repo.url}/issues")
        .header("Authorization", s"Basic $token")
        .header("Content-Type", "application/json")
        .asString.body).values

  def createIssue(issue: Issue): Boolean = {
    val answer = Http(s"$URL/${repo.url}/issues")
        .postData(issue.toPostData)
        .header("Authorization", s"Basic $token")
        .asString.body
    println(answer)

    !Json.fromJson[Map[String, Any]](answer).get("type").contains("error")
  }

  def modifyIssue(id: IssueId, issue: Issue): Boolean = ???
  def addComment(id: IssueId, comment: Comment): Boolean = ???
}
