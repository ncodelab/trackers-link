package com.ncodelab.trackers.bitbucket

import com.fasterxml.jackson.core.`type`.TypeReference

object Kind extends Enumeration {
  type Kind = Value
  val bug, enhancement, proposal, task = Value
}

class IssueKindType extends TypeReference[Kind.type]
