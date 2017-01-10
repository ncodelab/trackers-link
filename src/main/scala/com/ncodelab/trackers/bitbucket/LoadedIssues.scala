package com.ncodelab.trackers.bitbucket

case class LoadedIssues(pagelen: Int, size: Int, values: List[Issue], page: Int, next: String)
