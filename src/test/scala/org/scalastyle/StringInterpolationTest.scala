// Copyright (C) 2011-2012 the original author or authors.
// See the LICENCE.txt file distributed with this work for additional
// information regarding copyright ownership.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package org.scalastyle

// scalastyle:off magic.number multiple.string.literals

import org.scalatest.junit.AssertionsForJUnit
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.scalastyle.file.CheckerTest
import org.scalastyle.file.FileLengthChecker

class StringInterpolationTest extends CheckerTest {
  val key = "this.is.custom"
  val classUnderTest = classOf[FileLengthChecker]
  val message = Some("custom")

  @Test def testOne() {
    val source = """
package foobar

object Foobar {
  val name = "Fred"
  println(s"Hello $name")
}
""";

    assertErrors(List(fileError(List("5"), message)), source, Map("maxFileLength" -> "5"), message, customId = Some("this.is.custom"))
  }
}
