package net.zerobuilder.examples.gradle;


import net.jbock.CommandLineArguments;
import net.jbock.ShortName;

@CommandLineArguments
abstract class TarArguments {

  @ShortName('x')
  abstract boolean extract();

  @ShortName('c')
  abstract boolean create();

  @ShortName('v')
  abstract boolean verbose();

  @ShortName('z')
  abstract boolean compress();

  @ShortName('f')
  abstract String file();
}
