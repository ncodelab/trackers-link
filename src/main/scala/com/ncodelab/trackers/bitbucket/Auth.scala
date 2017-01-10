package com.ncodelab.trackers.bitbucket

import java.util.Base64
import java.nio.charset.StandardCharsets

object Auth {
  type Token = String

  def auth(credentials: Credentials): Token = Base64.getEncoder
      .encodeToString((credentials.username + ":" + credentials.password)
          .getBytes(StandardCharsets.UTF_8))
}
