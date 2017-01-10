package com.ncodelab.trackers.bitbucket

case class Repository(username: String, name: String) {
  def url: String = username + "/" + name
}
