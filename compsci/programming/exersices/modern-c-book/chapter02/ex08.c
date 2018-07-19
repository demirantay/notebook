#include <stdio.h>
#include <stdlib.h>

int main(void) {
  float loan_amount, interest_rate, monthly_payment;

  printf("Loan amount: ");
  scanf("%f", &loan_amount);

  printf("Interest rate: ");
  scanf("%f", &interest_rate);

  printf("Monthly payment: ");
  scanf("%f", &monthly_payment);

  printf("Loan amount: %f | Monthly payment: %f | Interest rate: %f\n",
      loan_amount, monthly_payment, interest_rate);

  loan_amount = loan_amount + (loan_amount * interest_rate);
  loan_amount = loan_amount - monthly_payment;

  printf("Loan amount: %f | Monthly payment: %f | Interest rate: %f\n",
      loan_amount, monthly_payment, interest_rate);

  return 0;
}
