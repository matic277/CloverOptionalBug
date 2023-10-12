package org.example;

import java.time.LocalDate;
import java.util.Optional;



public class Customer
{
  final Long id;
  
  public Customer(Long id)
  {
    this.id = id;
  }
  
  private Optional<String> getMailingAddress()
  {
    return Optional.empty();
  }
  
  private Optional<String> getBillingAddress()
  {
    return Optional.empty();
  }
  
  public String getBillingAddressOrThrow(LocalDate d)
  {
    return getBillingAddress().orElseThrow();
  }
  
  public String getMailingAddressOrThrow(LocalDate d)
  {
    return getMailingAddress().orElseThrow();
  }
}
