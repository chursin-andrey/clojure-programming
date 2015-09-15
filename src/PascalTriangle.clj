(defn pascal [row col]
  (cond (= row 0) (if (= col 0) 1 (throw (Exception. "Out of range")))
    (= col 0) 1
    (= col row) 1
    (> row 1) (if (or (< col 0) (> col row))
                (throw (Exception. "Out of range"))
                (+ (pascal (dec row) (dec col))
                  (pascal (dec row) col)))
    :else (throw (Exception. "Out of range"))))

(for [row (range 0 10)
      col (range 0 (inc row))]
  (pascal row col))
