package org.example;

import java.time.LocalDate;
import java.util.Locale;


public class Printout
{
  private final Customer customer;
  
  public Printout(Customer customer)
  {
    this.customer = customer;
  }
  
  public String printoutStr(int i1, String s1, boolean i2)
  {
    final var billingAddress = customer.getBillingAddressOrThrow(LocalDate.now());
    final var mailingAddress = customer.getMailingAddressOrThrow(LocalDate.now());
    final var record = new Record("\n")
        .add("01", 1)
        .add("#####", 2)
        .add("#####", 3)
        .add("#####", 4)
        .add("#####", 5)
        .add("#####", 6)
        .add("#####", 7)
        .add("#####", 8)
        .add("#####", 9)
        .add("#####", 10)
        .add("#####", 11)
        .add("#####", 12)
        .add("#####", 13)
        .add("#####", 14);
    if (i2) record.add("blabla", 15);
    return record.toString();
  }
}
