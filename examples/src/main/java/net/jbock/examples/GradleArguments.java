package net.jbock.examples;


import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import net.jbock.CommandLineArguments;
import net.jbock.Description;
import net.jbock.LongName;
import net.jbock.Positional;
import net.jbock.ShortName;

@CommandLineArguments
abstract class GradleArguments {

  @ShortName('m')
  @Description(value = {"the message", "message goes here"}, argumentName = "MESSAGE")
  abstract Optional<String> message();

  @ShortName('f')
  @Description(value = "the files", argumentName = "FILE")
  abstract List<String> file();

  @Description(value = "the dir", argumentName = "DIR")
  abstract Optional<String> dir();

  @ShortName('c')
  @LongName("")
  @Description("cmos flag")
  abstract boolean cmos();

  @ShortName('v')
  abstract boolean verbose();

  @Positional
  abstract List<String> otherTokens();

  @Positional
  abstract List<String> ddTokens();

  @CommandLineArguments
  static abstract class Foo {
    abstract OptionalInt bar();
  }

  @CommandLineArguments
  static abstract class Bar {
    abstract List<String> bar();
  }
}