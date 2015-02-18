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
  )
