package com.ncodelab.trackers.bitbucket

import com.fasterxml.jackson.core.`type`.TypeReference

object Priority extends Enumeration {
  type Priority = Value
  val trivial, minor, major, critical, blocker = Value
}

class PriorityType extends TypeReference[Priority.type]
