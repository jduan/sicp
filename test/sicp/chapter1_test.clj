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
    )

  (testing "Exercise 1.2"
    (is (= (/ -37 150)
           (/ (+ 5 4
                 (- 2 (- 3 (+ 6 (/ 4 5)))))
              (* 3 (- 6 2) (- 2 7))))))

  (testing "Exercise 1.3"
    (is (= 58
           (sum-of-squares-of-two-largest 3 7 1)))
    (is (= 13
           (sum-of-squares-of-two-largest 1 2 3))))

  (testing "Exercise 1.4"
    (is (= 8
           (a-plus-abs-b 3 -5)))
    (is (= 10
           (a-plus-abs-b 5 5))))

  (testing "Exercise 1.5"
    (is (thrown? StackOverflowError (mytest 0 (p)))))

  (testing "Exercise 1.6"
    (is (thrown? StackOverflowError (square-root2 2))))

  (testing "Exercise 1.7"
    (is (= 1.4142156862745097 (square-root 2))))
  )
