package com.ncodelab.trackers.bitbucket

import java.util.{Date, Optional}

import com.fasterxml.jackson.annotation.{JsonFormat, JsonProperty}
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.module.scala.JsonScalaEnumeration
import com.ncodelab.trackers.bitbucket.IssueKind.IssueKind
import com.ncodelab.trackers.bitbucket.IssueState.IssueState
import com.ncodelab.trackers.bitbucket.Priority.Priority

case class Issue(
                    @JsonScalaEnumeration(classOf[PriorityType]) priority: Priority,
                    @JsonScalaEnumeration(classOf[IssueKindType]) kind: IssueKind,
                    title: String,
                    state: IssueState,
                    reporter: User,
                    assignee: User,
                    content: IssueContent,
                    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss") @JsonProperty("created_on") createdAt: Date,
                    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss") @JsonProperty("updated_on") updatedAt: Date,
                    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss") @JsonProperty("edited_on") editedAt: Date
                )
