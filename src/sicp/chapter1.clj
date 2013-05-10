(ns sicp.chapter1)

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(defn sum-of-squares-of-two-largest [& args]
  (letfn [(square [x] (* x x))
          (largest [xs] (take 2 (reverse (sort xs))))]
    (apply + (map square (largest args)))))

(defn a-plus-abs-b [a b]
  ((if (> b 0) + -) a b))
