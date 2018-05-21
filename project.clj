(defproject try-shadow-cljs "0.1.1"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  ;:jvm-opts ["--add-modules" "java.xml.bind"]
  :dependencies [
                 [org.clojure/clojure "1.9.0"]
                 [org.clojure/clojurescript "1.10.238"]
                 [re-frame "0.10.5"]
                 [thheller/shadow-cljs "2.3.23"]
                 ]
  :plugins [[lein-cljfmt "0.5.7"]])
