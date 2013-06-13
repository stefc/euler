(ns euler.problem17)

(def numbers { 1 "one" 2 "two" 3 "three" 4 "four" 5 "five" 6 "six" 7 "seven" 8 "eight" 9 "nine" 
	10 "ten" 20 "twenty" 30 "thirty" 40 "forty" 50 "fifty" 60 "sixty" 70 "seventy" 80 "eighty" 90 "ninety"
	100 "hundred" 1000 "thousand" 
	11 "eleven" 12 "twelve" 13 "thirteen" 14 "fourteen" 15 "fifteen" 16 "sixteen" 17 "seventeen" 18 "eighteen" 19 "nineteen"})

(defn tenth [n] 
	(* (int (/ n 10)) 10 ))

(defn hundred [n] 
	(* (int (/ n 100)) 100 ))

(defn number-to-str [n]
	(loop [no n acc ""]
		;(println no)
		(cond 
			(= no 0) acc
			(= no 1000) 	(recur 0 (str (numbers 1) (numbers 1000)))
			(and (>= no 100) (zero? (rem no 100))) (recur 0 (str (numbers (/ (hundred no) 100 )) (numbers 100))) 
			(>= no 100) 	(recur (- no (hundred no)) (str (numbers (/ (hundred no) 100 ))  (numbers 100) "and"  acc ))
			(< no 21)		(recur 0 	(str acc (numbers no)))
			:else 			(recur (- no (tenth no)) (str acc (numbers (tenth no)))))))

(apply + (map #(count (number-to-str %)) (range 1 1001)))