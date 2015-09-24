;returns set of an one element
(defn singleton-set [x] (fn [elem] (= x elem)))

;checks if the set contains an element
(defn contains? [x set] (some (partial = x) set))

(defn adjoin-set [x set]
  (if (contains? x set) set
    (cons x set)))

;Returns the union of the two given sets,
;the sets of all elements that are in either `s` or `t`.
(defn union [s t]
  (reduce #(adjoin-set %2 %1) s t))

;Returns the intersection of the two given sets,
;the set of all elements that are both in `s` and `t`.
(defn intersect [s t]
  (filter #(contains? % s) t))

(def l (list 1 2 3))
(vec l)
(contains [1,2,3,4,5] 4)
(contains [1,2,3,4,5] 6)
(adjoin-set 6 [1,2,3,4,5])
(union [1,2,3] [4,5])
(union #{1,2,3} #{4,5})
(intersect #{1,2,3,4,5} [4,5,6])
(intersect #{1,2,3,4,5} #{4,5,6})

;Returns the difference of the two given sets,
;the set of all elements of `s` that are not in `t`.
(defn diff [s t]
  (if (< (count s) (count t))
    (reduce (fn [result item]
              (if (contains? t item)
                (disj result item)
                result))
      s t)
    (reduce disj s t)))

(diff #{1,2,3,4,5} [4,5,6])

;Displays the contents of a set
(defn to-string [s] (reduce #(str %1 "," %2) s))

;Returns the subset of `s` for which `p` holds.
(defn filter [s f] ()) ;implement

(defn filter-set
  [pred set]
  (reduce (fn [s x] (if (pred x) s (disj s x)))
    set set))

(filter-set even? #{1 2 3 4 5 6})

;The bounds for `forall` and `exists` are +/- 1000.
(def bound 1000)

;Returns whether all bounded integers within `s` satisfy `p`.
(defn forall [s f]()) ;implement

;Returns whether there exists a bounded integer within `s`
;that satisfies `p`.
(defn exists [s f] ()) ;implement

;Returns a set transformed by applying `f` to each element of `s`.
(defn map [s f] ()) ;implement

