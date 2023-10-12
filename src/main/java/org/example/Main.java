package org.example;

import java.util.Optional;


public class Main
{
  public static void main(String[] args)
  {
    Optional<Integer> o = Optional.of(1);
    var o2 = Optional.of(2);
    record Test(int x) { }
    new Test(5);
  }
}