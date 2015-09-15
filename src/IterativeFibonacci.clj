(defn fib [n]
  (fib-iter 1 0 n))

(defn fib-iter [a b count]
  (if (= count 0)
    b
  (fib-iter (+ a b) a (- count 1))))

(fib 56) ;225851433717