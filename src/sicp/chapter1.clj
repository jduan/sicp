(ns sicp.chapter1)

(defn bigger [a b]
  (if (>= a b) a b))
(defn sum-of-squares [a b]
  (+ (* a a) (* b b)))
(defn sum-of-squares-of-two-largest [a b c]
  (cond (>= a b) (sum-of-squares a (bigger b c))
        :else (sum-of-squares b (bigger a c))))

(defn a-plus-abs-b [a b]
  ((if (> b 0) + -) a b))

(defn p []
  (p))
;; mytest isn't a special form so clojure doesn't know internally it uses an
;; "if" form. So it evaluates its parameters x and y first then evalute its body
;; with x and y
(defn mytest [x y]
  (if (= x 0) 0 y))

;; 1.1.6 new-if
;; The new form of "new-if" is implemented as a regular procedure. Regular
;; procedures use the "applicative-order" evaluation. In this case,
;; square-root-internal will be called over and over again.
(defn square-root2 [x]
  (letfn [(new-if [pred then-clause else-clause]
            (cond pred then-clause
                  :else else-clause))
          (abs [x]
            (if (> x 0) x (- x)))
          (square-root-internal [guess]
            (new-if (good-enough? guess)
              guess
              (square-root-internal (improve-guess guess))))
          (improve-guess [guess]
            (average guess (/ x guess)))
          (average [a b]
            (/ (+ a b) 2.0))
          (good-enough? [guess]
            (< (abs (- (* guess guess) x)) 0.001))
          ]
    (square-root-internal 1)))

;; 1.1.7 square roots by Newton's method
(defn square-root [x]
  (letfn [(abs [x]
            (if (> x 0) x (- x)))
          (square-root-internal [guess]
            (if (good-enough? guess)
              guess
              (square-root-internal (improve-guess guess))))
          (improve-guess [guess]
            (average guess (/ x guess)))
          (average [a b]
            (/ (+ a b) 2.0))
          (good-enough? [guess]
            (< (/ (abs (- (* guess guess) x)) x) 0.00000000000001))]
    (square-root-internal 1)))

;; 1.8 cube roots by Newton's method
(defn cube-root [x]
  (letfn [(abs [x]
            (if (> x 0) x (- x)))
          (cube-root-internal [guess]
            (if (good-enough? guess)
              guess
              (cube-root-internal (improve-guess guess))))
          (improve-guess [guess]
            (/ (+ (/ x (* guess guess))
                  (* 2 guess))
               3.0))
          (good-enough? [guess]
            (< (/ (abs (- (* guess guess guess) x)) x) 0.00000000000001))]
    (cube-root-internal 1)))

;; iterative factorial
(defn factorial [n]
  (letfn [(factorial-iter [acc counter]
            (if (= counter 1)
              acc
              (factorial-iter (* acc counter) (- counter 1))))]
    (factorial-iter 1 n)))

(defn fib-recur [n]
  (if (< n 2) n
    (+ (fib-recur (dec n)) (fib-recur (- n 2)))))

(defn fib-iter [n]
  (letfn [(helper [a b count]
            (if (zero? count) b
              (helper (+ a b) a (dec count))))]
    (helper 1 0 n)))

;; Exercise 1.9
;; The first procedure is recursive.
;; The second procedure is iterative

;; counting change
(defn count-change2 [n denoms]
  (cond (empty? denoms) 0
        (zero? n) 1
        (>= n (first denoms)) (+ (count-change2 (- n (first denoms)) denoms)
                                 (count-change2 n (rest denoms)))
        :else (count-change2 n (rest denoms))))
(defn cc [n]
  ;; Counting change
  ;; Given 50, 25, 10, 5, and 1, how many different ways can we make changes of n?
  (defn max-of-kind [kind]
    (cond (= kind 5) 50
          (= kind 4) 25
          (= kind 3) 10
          (= kind 2) 5
          (= kind 1) 1))

  ;; The idea is:
  ;; When you make changes, you use either a kind of coins or you don't.
  (defn count-change [n kinds]
    (let [max-kind (max-of-kind kinds)]
      (cond (= 1 kinds) 1
            (>= n max-kind) (+ (count-change (- n max-kind) kinds)
                               (count-change n (- kinds 1))
                               )
            :else (count-change n (- kinds 1)))))

  (count-change n 5))

;; Exercise 1.11
(defn f11-recur [n]
  (if (< n 3) n
    (+ (f11-recur (dec n))
       (* 2 (f11-recur (- n 2)))
       (* 3 (f11-recur (- n 3))))))

(defn f11-iter [n]
  (defn helper [n a b c]
    (if (zero? n) a
      (helper (dec n) b c (+ c (* 2 b) (* 3 a)))))
  (helper n 0 1 2))

;; Exercise 1.12

;; Given a list like (1 5 10 10 5 1), return (1 6 15 20 15 6)
(defn next-level [lst]
  (concat
    (cons 1
          (map (fn [lst] (apply + lst)) (partition 2 1 lst))) '(1)))

(defn pascal-triangle [n]
  (cond (= 1 n) '(1)
        (= 2 n) '(1 1)
        :else (next-level (pascal-triangle (dec n)))))

;; Exercise 1.15
;; a. 5 times
;; b. the space and time complexity are log3 of n

;; Exercise 1.16
(defn square [n] (*' n n))
(defn fast-expr-recur [b n]
  (cond (zero? n) 1
        (even? n) (square (fast-expr-recur b (/ n 2)))
        :else (*' b (fast-expr-recur b (dec n)))))

(defn fast-expr-iter [b n]
  (defn helper [b n acc]
    (cond (zero? n) acc
          (even? n) (helper (square b) (/ n 2) acc)
          :else (helper (square b) (/ (dec n) 2) (* acc b))))
  (helper b n 1))
