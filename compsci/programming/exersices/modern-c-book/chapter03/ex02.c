#include <stdio.h>

int main(void) {
  int item_number;
  int day, month, year;
  float price;

  printf("Enter item number: ");
  scanf("%d", &item_number);

  printf("Enter unit price: ");
  scanf("%f", &price);

  printf("Enter purchase date: (dd/mm/yyyy): ");
  scanf("%d/%d/%d", &day, &month, &year);

  printf("Item \tUnite Price \tPurchase Date\n");
  printf("%d \t%f \t%d/%d/%d\n", item_number, price, day, month, year);


  return 0;
}
