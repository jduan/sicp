(ns sicp.chapter2)

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

