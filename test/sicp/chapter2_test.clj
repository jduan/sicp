(ns sicp.chapter2-test
  (:use clojure.test
        sicp.chapter2))

(deftest a-test
  (testing "Exercise 2.1"
    (is (= (gcd 4 8) 4))
    (is (= (gcd 4 6) 2))
    (is (= (numer (make-rat 3 4)) 3))
    (is (= (denom (make-rat 3 4)) 4))
    (is (= (add-rat (make-rat 3 4) (make-rat 5 6)) (make-rat 19 12)))
    (is (= (sub-rat (make-rat 3 4) (make-rat 5 6)) (make-rat -1 12)))
    (is (= (mul-rat (make-rat 3 4) (make-rat 5 6)) (make-rat 5 8)))
    (is (= (div-rat (make-rat 3 4) (make-rat 5 6)) (make-rat 9 10)))
    (is (= true (equal-rat? (make-rat 3 4) (make-rat 9 12))))
    (is (= 3 (numer (make-rat2 -12 -16))))
    (is (= 4 (denom (make-rat2 -12 -16))))
    (is (= -3 (numer (make-rat2 12 -16))))
    (is (= 4 (denom (make-rat2 12 -16))))
    )

  (testing "Exercise 2.2"
    (is (= 3 (x-point (make-point 3 4))))
    (is (= 4 (y-point (make-point 3 4))))
    (is (= (make-point 3 4) (start-segment
                              (make-segment (make-point 3 4)
                                            (make-point 7 8)))))
    (is (= (make-point 7 8) (end-segment
                              (make-segment (make-point 3 4)
                                            (make-point 7 8)))))
    (is (= (midpoint-segment (make-segment (make-point 1 1) (make-point 2 2)))
           (make-point 3/2 3/2)))
    (is (= (midpoint-segment (make-segment (make-point 1 1)
                                           (make-point -2 -2)))
           (make-point -1/2 -1/2)))
    )

  (testing "Exercise 2.3"
    (is (= (rectangle-width (make-rectangle
                              (make-point 3 4) (make-point 7 18)))
           4))
    (is (= (rectangle-height (make-rectangle
                              (make-point 3 4) (make-point 7 18)))
           14))
    (is (= (rectangle-perimeter (make-rectangle
                                  (make-point 3 4) (make-point 7 18)))
           36))
    (is (= (rectangle-area (make-rectangle
                             (make-point 3 4) (make-point 7 18)))
           56))
    )
  (is (= (rectangle-perimeter2 (make-rectangle2
                                 (make-point 3 4) 7 8))
         30))
  (is (= (rectangle-area2 (make-rectangle2
                            (make-point 3 4) 7 8))
         56))

  (testing "Exercise 2.4"
    (is (= (car1 (cons1 3 4)) 3))
    (is (= (cdr1 (cons1 3 4)) 4))
    )

  (testing "Exercise 2.5"
    (is (= (car2 (cons2 3 4)) 3))
    (is (= (cdr2 (cons2 3 4)) 4))
    )

  (testing "Exercise 2.6"
    (is (= ((one inc) 0) 1))
    (is (= ((two inc) 0) 2))
    (is (= (((plus one two) inc) 0) 3))
    (is (= (((plus four seven) inc) 0) 11))
    )

  (testing "Exercise 2.7"
    (is (= (lower-bound (make-interval 3 7)) 3))
    (is (= (lower-bound (make-interval 7 3)) 3))
    (is (= (upper-bound (make-interval 7 3)) 7))
    (is (= (upper-bound (make-interval 3 7)) 7))
    (is (= (add-interval (make-interval 3 7)
                         (make-interval 5 10))
           (make-interval 8 17)))
    (is (= (mul-interval (make-interval 3 7)
                         (make-interval 5 10))
           (make-interval 15 70)))
    (is (= (div-interval (make-interval 3 7)
                         (make-interval 5 10))
           (make-interval 3/10 7/5)))
    (is (= (sub-interval (make-interval 3 7)
                         (make-interval 5 10))
           (make-interval -7 2)))
    )

  )
