(ns ls.core
  (:require [reagent.core :as r]
            [soda-ash.core :as sa]
            [reagent.session :as session]
            [bidi.bidi :as bidi]
            [accountant.core :as accountant]))

(enable-console-print!)

(def app-routes
  ["/"
   [["" :index]
    ["login" :login]
    ["signup" :sign-up]
    [true :four-o-four]]])

(defn menu []
  [:div.ui.large.secondary.inverted.pointing.menu
   [:a.active.item {:href (bidi/path-for app-routes :index)} "Home"]
   [:a.item {:href (bidi/path-for app-routes :mamma)} "Not home"]
   [:a.item "Away"]
   [:div.right.item
    [:a.ui.inverted.button {:href (bidi/path-for app-routes :login)} "Log in"]
    [:a.ui.inverted.button {:href (bidi/path-for app-routes :sign-up)} "Sign up"]]])


(defn main-content []
  [:div.ui.vertical.stripe.segment
   [:div.ui.middle.aligned.stackable.grid.container


    [:h3.ui.header "Vi kan hjelpe deg"]
    [:p "Den spesielle optiske illusjonen forekommer bare én gang i året, noen få dager i midten av februar, dersom værforholdene tillater det.\n\nPå nasjonalparkens hjemmesider kan man lese:\n\n«Horsetail Fall-fenomenet oppstår når vinkelen av solen som er i ferd med å gå ned setter fyr på fossefallet i sjatteringer av rødt og oransje, som om det er ild som faller ned El Capitan»"]
    [:h3.ui.header "Ja vi kan faktisk det"]
    [:p "Den spesielle optiske illusjonen forekommer bare én gang i året, noen få dager i midten av februar, dersom værforholdene tillater det.\n\nPå nasjonalparkens hjemmesider kan man lese:\n\n«Horsetail Fall-fenomenet oppstår når vinkelen av solen som er i ferd med å gå ned setter fyr på fossefallet i sjatteringer av rødt og oransje, som om det er ild som faller ned El Capitan»"]
    ]])

(defn more-main-content []
  [:div.ui.vertical.stripe.quote.segment
   [:div.ui.equal.width.stackable.internally.celled.grid
    [:div.center.aligned.row
     [:div.column
      [:h3 "Mye bra å si om disse folka"]
      [:p "F.eks. sa de ditt og datt, og mye annet"]]
     [:div.column
      [:h3 "Beste jeg har hatt"]
      [:p "F.eks. sa de ditt og datt, og mye annet"]]
     ]]])

(defmulti main-content-multi identity)

(defmethod main-content-multi :login []
          [:div "login og greier"])

(defmethod main-content-multi :index []
  [:div.ui.text.container
   [:h1.ui.inverted.header
    "Header her " (session/get :route)]
   [:h2 "Et sted å grunde litt!"]
   [:div.ui.huge.primary.button "Kjør på " [:i.right.arrow.icon]]])

(defmethod main-content-multi :default []
  [:div "her da"])

(defn main []
  (println "snuppedup")

  (fn []
    (let [page (:current-page (session/get :route))]
      [:div.pusher
       [:div.ui.inverted.vertical.masthead.center.aligned.segment
        [:div.ui.container
         [menu]
         [main-content-multi page]]]
       [more-main-content]])))

(defn start []
  (r/render-component
    [main]
    (.getElementById js/document "app")))

(defn init! []
  (accountant/configure-navigation!
    {:nav-handler  (fn
                     [path]                                 ;;(1)
                     (let [match (bidi/match-route app-routes path)
                           current-page (:handler match)
                           route-params (:route-params match)]
                       (session/put! :route {:current-page current-page
                                             :route-params route-params})))
     :path-exists? (fn [path]
                     (boolean (bidi/match-route app-routes path)))})
  (accountant/dispatch-current!))

(init!)
(start)