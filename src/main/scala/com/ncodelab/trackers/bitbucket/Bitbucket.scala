package com.ncodelab.trackers.bitbucket

import com.ncodelab.trackers.Json
import com.ncodelab.trackers.bitbucket.Auth.Token

import scalaj.http._

class Bitbucket(val token: Token) {
  val URL = "https://api.bitbucket.org/2.0/repositories"

  type IssueId = String

  def loadIssues(repo: Repository): List[Issue] =
    Json.fromJson[LoadedIssues](Http(s"$URL/${repo.url}/issues")
        .header("Authorization", s"Basic $token")
        .asString.body).values
  def createIssue(issue: Issue): Boolean = ???
  def modifyIssue(id: IssueId, issue: Issue): Boolean = ???
  def addComment(id: IssueId, comment: Comment): Boolean = ???
}
