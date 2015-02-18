(ns sicp.chapter2-test
  (:use clojure.test
        sicp.chapter2))

(deftest a-test
  (testing "Exercise 2.1"
    (is (= 10 10))
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
