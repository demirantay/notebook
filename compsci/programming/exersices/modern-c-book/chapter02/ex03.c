#include <stdio.h>

int main(void) {
  float interest_rate = 0.05;
  float amount;

  printf("Enter $ amount: ");
  scanf("%f", &amount);

  // yearly increase is %5
  float yearly_increase = amount * interest_rate;
  amount += yearly_increase;

  printf("With tax added: %.2f$\n", amount);


  return 0;
}
