package com.ncodelab.trackers.bitbucket

import com.ncodelab.trackers.Json
import com.ncodelab.trackers.bitbucket.Auth.Token

import scalaj.http._

class Bitbucket(val token: Token, val repo: Repository) {
  val URL: String = "https://api.bitbucket.org/2.0/repositories"
  // TODO: change to v1!
  val URLv1: String = "https://api.bitbucket.org/1.0/repositories"

  type IssueId = String

  def loadIssues(): List[Issue] =
    Json.fromJson[LoadedIssues](Http(s"$URL/${repo.url}/issues")
        .header("Authorization", s"Basic $token")
        .header("Content-Type", "application/json")
        .asString.body).values

  def writeIssue(issue: Issue): Option[Issue] = {
    val answer = Http(s"$URL/${repo.url}/issues")
        .postData(issue.toPostData)
        .header("Authorization", s"Basic $token")
        .header("Content-Type", "application/json")
        .asString.body
    val created = !Json.fromJson[Map[String, Any]](answer)
        .get("type").contains("error")

    if (created) Option(Json.fromJson[Issue](answer)) else Option.empty
  }

  def deleteIssue(id: IssueId): Boolean =
    Http(s"$URL/${repo.url}/issues/$id")
        .method("DELETE")
        .header("Authorization", s"Basic $token")
        .asString.code == 204

  def modifyIssue(issue: Issue): Issue = {
    val answer = Http(s"$URLv1/${repo.url}/issues/${issue.id.get}")
        .postData(issue.toPostData)
        .method("PUT")
        .header("Authorization", s"Basic $token")
        .header("Content-Type", "application/json")
        .asString.body

    println(answer)

    Json.fromJson[Issue](answer)
  }
  def addComment(id: IssueId, comment: Comment): Boolean = ???
}
