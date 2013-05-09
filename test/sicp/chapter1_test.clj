(ns sicp.chapter1-test
  (:use clojure.test
        sicp.chapter1))

;; ex-1.1
(def a 3)
(def b 4)
(deftest a-test
  (testing "Exercise 1.1"
           (is (= 10 10))
           (is (= 12 (+ 5 3 4)))
           (is (= 8 (- 9 1)))
           (is (= 3 (/ 6 2)))
           (is (= 6 (+ (* 2 4) (- 4 6))))
           (is (= 19 (+ a b (* a b))))
           (is (= false (= a b)))
           (is (= 4 (if (and (> b a) (< b (* a b)))
                      b
                      a)))
           (is (= 16 (cond (= a 4) 6
                           (= b 4) (+ 6 7 a)
                           :else 25)))
           (is (= 6 (+ 2 (if (> b a) b a))))
           (is (= 16 (* (cond (> a b) a
                              (< a b) b
                              :else -1)
                        (+ a 1))))
           ))
