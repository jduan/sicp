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
    (is (= 1.414213562373095 (square-root 2)))
    (is (= 0.01 (square-root 0.0001)))
    (is (= 6.5759594913922966E7 (square-root 4324324323243243))))

  (testing "Exercise 1.8"
    (is (= 1.2599210498948732 (cube-root 2)))
    (is (= 0.04641588833612779(cube-root 0.0001)))
    (is (= 162919.38155485757 (cube-root 4324324323243243))))

  (testing "Fibnacci"
    (is (= 832040 (fib-recur 30)))
    (is (= 2880067194370816120 (fib-iter 90)))
    )

  (testing "Counting change"
    (is (= 292 (cc 100)))
    (is (= 50 (cc 50)))
    )

  (testing "Exercise 1.11 recursive"
    (is (= 0 (f11-recur 0)))
    (is (= 1 (f11-recur 1)))
    (is (= 2 (f11-recur 2)))
    (is (= 4 (f11-recur 3)))
    (is (= 11 (f11-recur 4)))
    (is (= 25 (f11-recur 5)))
    )

  (testing "Exercise 1.11 iterative"
    (is (= 0 (f11-iter 0)))
    (is (= 1 (f11-iter 1)))
    (is (= 2 (f11-iter 2)))
    (is (= 4 (f11-iter 3)))
    (is (= 11 (f11-iter 4)))
    (is (= 25 (f11-iter 5)))
    )

  (testing "Exercise 1.12 next-level"
    (is (= '(1 2 1) (next-level '(1 1))))
    (is (= '(1 4 6 4 1) (next-level '(1 3 3 1))))
    (is (= '(1 5 10 10 5 1) (next-level '(1 4 6 4 1))))
    )

  (testing "Exercise 1.12 pascal-triangle"
    (is (= '(1) (pascal-triangle 1)))
    (is (= '(1 1) (pascal-triangle 2)))
    (is (= '(1 2 1) (pascal-triangle 3)))
    (is (= '(1 4 6 4 1) (pascal-triangle 5)))
    (is (= '(1 5 10 10 5 1) (pascal-triangle 6)))
    )

  )
