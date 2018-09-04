package net.jbock.examples;

import net.jbock.examples.fixture.ParserTestFixture;
import org.junit.jupiter.api.Test;

class SimpleArgumentsTest {

  private ParserTestFixture<SimpleArguments> f =
      ParserTestFixture.create(SimpleArguments_Parser.create());

  @Test
  void invalidOptions() {
    f.assertThat("xf", "1").failsWithLine4("Invalid option: xf");
    f.assertThat("-xf", "1").failsWithLine4("Invalid option: -xf");
  }

  @Test
  void success() {
    f.assertThat("--file", "1").succeeds("file", "1", "extract", false);
  }

  @Test
  void errorHelpNotFirstArgument() {
    f.assertThat("--file", "1", "--help").failsWithLines(
        "Usage:",
        "  SimpleArguments [<options>]",
        "",
        "Error:",
        "  Invalid option: --help",
        "",
        "Try 'SimpleArguments --help' for more information.",
        "",
        "");
  }

  @Test
  void testPrint() {
    f.assertPrints(
        "NAME",
        "  SimpleArguments",
        "",
        "SYNOPSIS",
        "  SimpleArguments [<options>]",
        "",
        "DESCRIPTION",
        "",
        "OPTIONS",
        "  -x, --extract",
        "",
        "  --file <file>",
        "",
        "  --help",
        "    Print this help page.",
        "    The help flag may only be passed as the first argument.",
        "    Any further arguments will be ignored.",
        "",
        "");
  }
}
