(ns scorecard-test
	(:use clojure.contrib.test-is 
		scorecard))

(deftest test-third
	(is (= 3 (third [1 2 3 4]))))

(deftest test-first-two
	(is (= 3 (first-two [1 2 3]))))

(deftest test-remove-frame
	(is (= [3 4 5] (remove-frame [0 1 2 3 4 5])))
	(is (= [3 4] (remove-frame [10 3 4])))
	(is (= [5] (remove-frame [6 4 5]))))

(deftest test-remvo-two-frames
	(is (= [] 
		(remove-frame 
			(remove-frame [0 1 2 0 0 0])))))

(deftest test-scores
	(is (= 0 (score [])))
	(is (= 6 (score [1 2 3])))
	(is (= 15 (score [1 2 3 4 5 0])))
	(is (= 19 (score [10 1 2 3])))
	(is (= 17 (score [5 5 1 2 3])))
	(is (= 300 (score [10 10 10 10 10 10 10 10 10 10 10 10])))
	(is (= 19 (score [5 5 1 0 0 1 0 0 1 0 0 1 0 0 1 0 0 1 0 0 1 0 0 1 0 0 ])))
	(is (= 21 (score [10 1 1 0 1 0 0 1 0 0 1 0 0 1 0 0 1 0 0 1 0 0 1 0 0 ]))))

