#include <stdio.h>

int main(void) {
  int first_date, first_month, first_year;
  int second_date, second_month, second_year;

  printf("Enter first date (dd/mm/yy) : ");
  scanf("%d/%d/%d", &first_date, &first_month, &first_year);

  printf("Enter second date (dd/mm/yy) : ");
  scanf("%d/%d/%d", &second_date, &second_month, &second_year);

  if (second_year < first_year) {
    printf(
      "%d/%d/%d is erlier than %d/%d/%d \n",
      second_date, second_month, second_year,
      first_date, first_month, first_year
    );
  }
  else if (first_year < second_year) {
    printf(
      "%d/%d/%d is erlier than %d/%d/%d \n",
      first_date, first_month, first_year
      second_date, second_month, second_year,
    );
  }

  return 0;
}
