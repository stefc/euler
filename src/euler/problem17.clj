(ns euler.problem17)

(def numbers { 1 "one" 2 "two" 3 "three" 4 "four" 5 "five" 6 "six" 7 "seven" 8 "eight" 9 "nine" 
	10 "ten" 20 "twenty" 30 "thirty" 40 "fourty" 50 "fifty" 60 "sixty" 70 "seventy" 80 "eighty" 90 "ninety"
	100 "hundred" 1000 "thousand" 
	11 "elven" 12 "twelve" 13 "thirteen" 14 "fourteen" 15 "fifteen" 16 "sixteen" 17 "seventeen" 18 "eighteen" 19 "nineteen"})

(defn tenth [n] 
	(* (int (/ n 10)) 10 ))

(defn hundred [n] 
	(* (int (/ n 100)) 100 ))

(defn thousand [n] 
	(* (int (/ n 1000)) 1000 ))


(defn number-to-str [n]
	(loop [no n acc ""]
		(println no)
		(cond 
			(= no 0) acc
			(>= no 1000) 	(recur (- no (thousand no)) (str (numbers (/ (thousand no) 1000 ))  (numbers 1000))
			(>= no 100) 	(recur (- no (hundred no)) (str (numbers (/ (hundred no) 100 )) "and" (numbers 100) acc ))
			(< no 21)		(recur 0 	(str acc (numbers no)))
			:else 			(recur (- no (tenth no)) (str acc (numbers (tenth no)))))))

; three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters

(number-to-str 342)
(number-to-str 115)
