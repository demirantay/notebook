#include <stdio.h>

// my functions
void find_erlier(int d1, int m1, int y1, int d2, int m2, int y2);

int main(void) {
  int d1 = 31, m1 = 12, y1 = 99;
  int d2, m2, y2;

  while (1) {
    printf("Enter a date (dd/mm/yy) : ");
    scanf("%d/%d/%d", &d2, &m2, &y2);

    if (d2 == 0 || m2 == 0 || y2 == 0) {
      break;
    }
    else {
      find_erlier(d1, m1, y1, d2, m2, y2);
    }
  }
  printf("%d/%d/%d is the erliest!\n", d1, m1, y1);

  return 0;
}

void find_erlier(int d1, int m1, int y1, int d2, int m2, int y2) {
  if (y1 < y2) {
    // do nothing
  }
  else if (y2 < y1) {
    d1 = d2;
    m1 = m2;
    y1 = y2;
  }
  else if (y1 == y2 && m1 < m2) {
    // do nothing
  }
  else if (y1 == y2 && m2 < m1) {
    d1 = d2;
    m1 = m2;
    y1 = y2;
  }
  else if (y1 == y2 && m1 == m2 && d1 < d2) {
    // do nothing
  }
  else if (y1 == y2 && m1 == m2 && d2 < d1) {
    d1 = d2;
    m1 = m2;
    y1 = y2;
  }
}
