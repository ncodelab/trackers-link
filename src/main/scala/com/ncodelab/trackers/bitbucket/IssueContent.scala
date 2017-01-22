package com.ncodelab.trackers.bitbucket

object IssueContent {
  def md(text: String): IssueContent = {
    IssueContent(text, "markdown", "")
  }
}

case class IssueContent(raw: String, markup: String, html: String)
