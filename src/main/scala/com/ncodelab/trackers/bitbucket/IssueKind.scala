package com.ncodelab.trackers.bitbucket

import com.fasterxml.jackson.core.`type`.TypeReference

object IssueKind extends Enumeration {
  type IssueKind = Value
  val bug, enhancement, proposal, task = Value
}

class IssueKindType extends TypeReference[IssueKind.type]
