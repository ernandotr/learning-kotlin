package dev.ernando

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class HelloTest {

  @Test
  fun hello() {

    assertThat("hello").isEqualTo("hello")
  }
}
