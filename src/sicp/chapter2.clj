(ns sicp.chapter2
  (:use [clojure.math.numeric-tower :only [expt]]
    ))

(defn gcd [x y]
  (letfn [(helper [small big]
            (if (zero? small) big
              (helper (rem big small) small)))]
    (let [small (if (<= x y) x y)
          big (if (<= x y) y x)]
      (helper small big))))

(defn make-rat [x y]
  (let [g (gcd x y)]
    (list (/ x g) (/ y g))))

(defn numer [rational]
  (first rational))

(defn denom [rational]
  (second rational))

(defn print-rat [rational]
  (do
    (print (numer rational))
    (print "/")
    (println (denom rational))))

(defn add-rat [x y]
  (make-rat (+ (* (numer x) (denom y))
               (* (numer y) (denom x)))
            (* (denom x) (denom y))))

(defn sub-rat [x y]
  (make-rat (- (* (numer x) (denom y))
               (* (numer y) (denom x)))
            (* (denom x) (denom y))))

(defn mul-rat [x y]
  (make-rat (* (numer x) (numer y))
            (* (denom x) (denom y))))

(defn div-rat [x y]
  (make-rat (* (numer x) (denom y))
            (* (denom x) (numer y))))

(defn equal-rat? [x y]
  (= (* (numer x) (denom y))
     (* (numer y) (denom x))))

;; Exercise 2.1
(defn abs [x]
     (if (> x 0) x (- x)))

(defn make-rat2 [x y]
  (if (>= (* x y) 0)
    (make-rat (abs x) (abs y))
    (make-rat (- 0 (abs x)) (abs y))))

;; Exercise 2.2
(defn make-point [x y]
  (list x y))

(defn x-point [p]
  (first p))

(defn y-point [p]
  (second p))

(defn print-point [p]
  (do
    (print "(")
    (print (x-point p))
    (print ",")
    (print (y-point p))
    (println ")")))

(defn make-segment [start-point end-point]
  (list start-point end-point))

(defn start-segment [segment]
  (first segment))

(defn end-segment [segment]
  (second segment))

(defn midpoint-segment [segment]
  (letfn [(average [x y] (/ (+ x y) 2))]
    (let [start-point (start-segment segment)
          end-point (end-segment segment)]
      (make-point
        (average (x-point start-point) (x-point end-point))
        (average (y-point start-point) (y-point end-point))))))

;; Exercise 2.3
(defn make-rectangle [down-left up-right]
  (list down-left up-right))

(defn rectangle-down-left [rectangle]
  (first rectangle))

(defn rectangle-up-right [rectangle]
  (second rectangle))

(defn rectangle-width [rectangle]
  (- (x-point (rectangle-up-right rectangle))
     (x-point (rectangle-down-left rectangle))))

(defn rectangle-height [rectangle]
  (- (y-point (rectangle-up-right rectangle))
     (y-point (rectangle-down-left rectangle))))

(defn rectangle-perimeter [rectangle]
  (* 2 (+ (rectangle-width rectangle)
          (rectangle-height rectangle))))

(defn rectangle-area [rectangle]
  (* (rectangle-width rectangle)
     (rectangle-height rectangle)))

(defn make-rectangle2 [down-left width height]
  (list down-left width height))

(defn rectangle-width2 [rectangle]
  (second rectangle))

(defn rectangle-height2 [rectangle]
  (nth rectangle 2))

(defn rectangle-perimeter2 [rectangle]
  (*  2 (+ (rectangle-width2 rectangle)
           (rectangle-height2 rectangle))))

(defn rectangle-area2 [rectangle]
  (* (rectangle-width2 rectangle)
     (rectangle-height2 rectangle)))

;; Exercise 2.4
(defn cons1 [x y]
  (fn [m] (m x y)))

(defn car1 [z]
  (z (fn [p q] p)))

(defn cdr1 [z]
  (z (fn [p q] q)))

;; Exercise 2.5
(defn cons2 [x y]
  (* (expt 2 x) (expt 3 y)))

(defn cons2helper [pair acc divisor]
  (if (zero? (rem pair divisor))
    (cons2helper (quot pair divisor) (inc acc) divisor)
    acc))

(defn car2 [pair]
  (cons2helper pair 0 2))

(defn cdr2 [pair]
  (cons2helper pair 0 3))

;; Exercise 2.6
(def zero
  (fn [f] (fn [x] x)))

(defn add-1 [n]
  (fn [f] (fn [x] (f ((n f) x)))))

(def one
  (fn [f] (fn [x] (f x))))

(def two
  (fn [f] (fn [x] (f (f x)))))

(defn plus [a b]
  (fn [f] (fn [x]
            ((b f)
             ((a f) x)))))

(def three (plus one two))
(def four (plus two two))
(def seven (plus three four))

;; Exercise 2.7
(defn make-interval [a b]
  (list a b))

(defn lower-bound [x]
  (min (first x) (second x)))

(defn upper-bound [x]
  (max (first x) (second x)))

(defn add-interval [x y]
  (make-interval (+ (lower-bound x) (lower-bound y))
                 (+ (upper-bound x) (upper-bound y))))

(defn mul-interval [x y]
  (let [p1 (* (lower-bound x) (lower-bound y))
        p2 (* (lower-bound x) (upper-bound y))
        p3 (* (upper-bound x) (lower-bound y))
        p4 (* (upper-bound x) (upper-bound y))]
    (make-interval (min p1 p2 p3 p4)
                   (max p1 p2 p3 p4))))

(defn div-interval [x y]
  (mul-interval x
                (make-interval (/ 1 (upper-bound y))
                               (/ 1 (lower-bound y)))))

(defn sub-interval [x y]
  (make-interval (- (lower-bound x) (upper-bound y))
                 (- (upper-bound x) (lower-bound y))))
