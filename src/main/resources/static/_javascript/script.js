const root = document.querySelector("html")
const checkbox = document.querySelector("input[name=theme]")

const getStyle = (element, style) => 
    window
        .getComputedStyle(element)
        .getPropertyValue(style)    


const initialColors = {
    bg: getStyle(root, "--bg")
}

const darkMode = {
    bg: "linear-gradient(130.74deg, #CBC657 43.52%, rgba(180, 74, 15, 0.6) 84.34%)"
}

const transformKey = key => 
    "--" + key.replace(/([A-Z])/g, "-$1").toLowerCase()


const changeColors = (colors) => {
    Object.keys(colors).map(key => 
        root.style.setProperty(transformKey(key), colors[key]) 
    )
}


checkbox.addEventListener("change", ({target}) => {
    target.checked ? changeColors(darkMode) : changeColors(initialColors)
})