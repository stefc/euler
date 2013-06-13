(ns euler.problem22)

(use '[clojure.string :only (split)])

(defn to-sum [s] 
	( apply + (map #(- (int %) 64) (str s))))

(defn values [s] 
	(map #(clojure.string/replace % #"\"(.*)\"" "$1") 
		(clojure.string/split s #",")))
(defn sd [] ())

(apply + 
	(map #(* %1 %2) 
		(map to-sum 
			(sort 
				(vec (values (slurp "http://projecteuler.net/project/names.txt"))))) (iterate inc 1)))
