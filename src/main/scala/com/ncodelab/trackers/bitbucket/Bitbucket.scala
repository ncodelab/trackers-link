package com.ncodelab.trackers.bitbucket

import com.ncodelab.trackers.Json
import com.ncodelab.trackers.bitbucket.Auth.Token

import scalaj.http._

class Bitbucket(val token: Token, val repo: Repository) {
  val URLv1: String = "https://api.bitbucket.org/1.0/repositories"

  type IssueId = String

  def http(url: String): HttpRequest = Http(s"$URLv1/${repo.url}/url")
      .header("Authorization", s"Basic $token")
      .header("Content-Type", "application/json")

  def loadIssues(): List[Issue] =
    Json.fromJson[LoadedIssues](http("issues").asString.body).values

  def createIssue(issue: Issue): Option[Issue] = {
    val answer = http("issues")
        .postData(issue.toPostData)
        .asString.body
    val created = !Json.fromJson[Map[String, Any]](answer)
        .get("type").contains("error")

    if (created) Option(Json.fromJson[Issue](answer)) else Option.empty
  }

  def deleteIssue(id: IssueId): Boolean =
    http(s"issues/$id")
        .method("DELETE")
        .asString.code == 204

  def modifyIssue(issue: Issue): Issue = {
    val answer = http(s"issues/${issue.id.get}")
        .postData(issue.toPostData)
        .method("PUT")
        .asString.body

    println(answer)

    Json.fromJson[Issue](answer)
  }
  def addComment(id: IssueId, comment: Comment): Boolean = ???
}
