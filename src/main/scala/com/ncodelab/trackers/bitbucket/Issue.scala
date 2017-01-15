package com.ncodelab.trackers.bitbucket

import java.text.SimpleDateFormat
import java.util.Date

import com.fasterxml.jackson.annotation.{JsonFormat, JsonProperty}
import com.fasterxml.jackson.module.scala.JsonScalaEnumeration
import com.ncodelab.trackers.bitbucket.IssueState.IssueState
import com.ncodelab.trackers.bitbucket.Kind.Kind
import com.ncodelab.trackers.bitbucket.Priority.Priority

case class Issue(
                    @JsonScalaEnumeration(classOf[PriorityType]) priority: Priority,
                    @JsonScalaEnumeration(classOf[IssueKindType]) kind: Kind,
                    title: String,
                    state: IssueState,
                    reporter: User,
                    assignee: User,
                    content: IssueContent,
                    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss") @JsonProperty("created_on") createdAt: Date,
                    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss") @JsonProperty("updated_on") updatedAt: Date,
                    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss") @JsonProperty("edited_on") editedAt: Date
                ) {
  val format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")

  def toPostData: String =
    s"priority=$priority&kind=$kind&state=$state&title=$title\n"
//       |created_on=${format.format(createdAt)}&
//       |updated_on=${format.format(updatedAt)}&
//       |edited_on=${format.format(editedAt)}&
//       |${if (reporter != null) "reporter=" + reporter.username + "&" else ""}
//       |${if (assignee != null) "assignee=" + assignee.username else ""}
//    """.stripMargin
}
