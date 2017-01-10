package com.ncodelab.trackers

import com.ncodelab.trackers.bitbucket._

object Main extends App {
//  override def main(args: Array[String]): Unit = {
    val token: Auth.Token = Auth.auth(Credentials("EuDgee", "jEMpqrFnQzpPv7zrBbk3K"))
    val issues: List[Issue] = new Bitbucket(token).loadIssues(Repository("restservices", "platform"))
    println(issues)
  //}
}
