#include <stdio.h>

int main(void) {
  float income, tax;

  printf("Type your income: ");
  scanf("%f", &income);

  if (income < 750.00f) {
    tax = income * 0.01f;
    printf("Annual tax due: %.2f$\n", tax);
  }
  else if (income > 750.00f && income < 2250.00f) {
    tax = ( income * 0.02f ) + 7.50;
    printf("Annual tax due: %.2f$\n", tax);
  }
  else if (income > 2250.00f && income < 3750.00f) {
    tax = ( income * 0.03f ) + 37.50;
    printf("Annual tax due: %.2f$\n", tax);
  }
  else {
    printf("Invalid income\n");
  }

  return 0;
}
