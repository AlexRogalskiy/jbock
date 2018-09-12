package net.jbock.examples;

import net.jbock.CommandLineArguments;
import net.jbock.Parameter;
import net.jbock.PositionalParameter;

import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;

@CommandLineArguments
abstract class AllLongsArguments {

  @PositionalParameter
  abstract List<Long> positional();

  @Parameter(shortName = 'i')
  abstract List<Long> listOfLongs();

  @Parameter(longName = "opt")
  abstract Optional<Long> optionalLong();

  @Parameter(longName = "optlong")
  abstract OptionalLong optionalPrimitiveLong();

  @Parameter(longName = "obj")
  abstract Long longObject();

  @Parameter(longName = "prim")
  abstract long primitiveLong();
}