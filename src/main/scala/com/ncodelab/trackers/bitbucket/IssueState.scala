package com.ncodelab.trackers.bitbucket

object IssueState {
  type IssueState = String

  val New = "new"
  val Open = "open"
  val Resolved = "resolved"
  val OnHold = "on hold"
  val Invalid = "invalid"
  val Duplicate = "duplicate"
  val WontFix = "wontfix"
  val Closed = "closed"
}
