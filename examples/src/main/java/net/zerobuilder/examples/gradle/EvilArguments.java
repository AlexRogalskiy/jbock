package net.zerobuilder.examples.gradle;

import net.jbock.CommandLineArguments;

@CommandLineArguments(grouping = true)
abstract class EvilArguments {

  abstract String fancy();

  abstract String fAncy();

  abstract String f_ancy();

  abstract String blub();

  abstract String Blub();
}