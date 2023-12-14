package com.example.finalproject

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ThirdActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var plantList: ArrayList<Plant>
    private lateinit var plantAdapter: PlantAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_homepage)

        // Initialize plantList
        plantList = ArrayList()

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Initialize plantList
        plantList = ArrayList()

        plantList.add(Plant(R.drawable.image1, "Bat Flower", "The Bat flower is a tropical plant native to southeast asia. It is a herbaceous perennial, growing from a rhizome and reaching up to three feet in height. The leaves are large, heart-shaped, and glossy green. The showy flowers are shaped like bats with yellow or purple wings that can reach five inches across. The flowers have a sweet scent and attract polinators such as flies, bees, and butterflies."))
        plantList.add(Plant(R.drawable.image2, "Carrion Plant", "Carrion flowers, also known as corpse flowers or stinking flowers, are mimetic flowers that emit an odor that smells like rotting flesh. Apart from the scent, carrion flowers often display additional characteristics that contribute to the mimesis of a decaying corpse. These include their specific coloration (red, purple, brown), the presence of setae and orifice-like flower architecture. Carrion flowers attract mostly scavenging flies and beetles as pollinators. Some species may trap the insects temporarily to ensure the gathering and transfer of pollen."))
        plantList.add(Plant(R.drawable.image3, "Chrysanthemum", "Chrysanthemums, sometimes called mums or chrysanths, are flowering plants of the genus Chrysanthemum in the family Asteraceae.[4] They are native to East Asia and northeastern Europe. Most species originate from East Asia and the center of diversity is in China. Countless horticultural varieties and cultivars exist."))
        plantList.add(Plant(R.drawable.image4, "Coralberry Tree", "The Coralberry tree is a species of flowering shrub native to North America. It grows up to 5-6 feet tall and produces clusters of small, white flowers in the late summer and early fall. The berries are a deep pink color and ripen in early autumn. The plant prefers moist soil and partial shade, but can tolerate full sun. The foliage is dark green and glossy. The bark is gray-brown with shallow furrows."))
        plantList.add(Plant(R.drawable.image5, "Crown Imperial", "Crown Imperial is a bulbous perennial plant of the lily family that grows to a height of about 90 cm. Its leaves are bright green, narrow and lance-shaped. The flowers are bell-shaped, with six petals in shades of red, yellow, and orange. They are followed by capsule-like fruits which contain small, black shiny seeds."))
        plantList.add(Plant(R.drawable.image6, "False Sunflower", "Flase sunflower is a herbaceous perennial plant native to North America. It is a member of the aster family and is also known as ox-eye sunflower or false sunflower. It grows up to 5 feet tall and has bright yellow daisy-like flowers that bloom from June to September. The leaves are oval to lance-shaped, with wavy edges and coarsely toothed margins. The stem is covered in short, fine hairs and the leaves often have reddish veins. False sunflowers are a popular choice for flower beds due to its long blooming period, easy maintenance, and bright colors."))
        plantList.add(Plant(R.drawable.image7, "Hibiscus", "Hibiscus is a genus of flowering plants in the mallow family, Malvaceae. The genus is quite large, comprising several hundred species that are native to warm temperate, subtropical and tropical regions throughout the world. Member species are renowned for their large, showy flowers and those species are commonly known simply as hibiscus, or less widely known as rose mallow. Other names include hardy hibiscus, rose of sharon, and tropical hibiscus."))
        plantList.add(Plant(R.drawable.image8, "Lobelia", "The genus Lobelia comprises a substantial number of large and small annual, perennial and shrubby species, hardy and tender, from a variety of habitats, in a range of colours. Many species appear totally dissimilar from each other. However, all have simple, alternate leaves and two-lipped tubular flowers, each with five lobes. The upper two lobes may be erect while the lower three lobes may be fanned out. Flowering is often abundant and the flower colour intense, hence their popularity as ornamental garden subjects."))
        plantList.add(Plant(R.drawable.image9, "Oriental Poppy", "Papaver orientale, the Oriental poppy, is a perennial flowering plant native to the Caucasus, northeastern Turkey, and northern Iran.Oriental poppies grow a mound of leaves that are hairy and finely dissected in spring. They gather energy and bloom in mid-summer. After flowering the foliage dies away entirely, a property that allows their survival in the summer drought of Central Asia. Gardeners can place late-developing plants nearby to fill the developing gap"))
        plantList.add(Plant(R.drawable.image10, "Periwinkle", "Vinca minor (common names lesser periwinkle or dwarf periwinkle) is a species of flowering plant in the dogbane family, native to central and southern Europe, from Portugal and France north to the Netherlands and the Baltic States, east to the Caucasus, and also southwestern Asia in Turkey. Vinca minor is a trailing subshrub, spreading along the ground and rooting along the stems to form large clonal colonies and occasionally scrambling up to 40 centimetres (16 in) high but never twining or climbing. The leaves are evergreen, opposite, 2–4.5 centimetres (0.79–1.77 in) long and 1–2.5 centimetres (0.39–0.98 in) broad, glossy dark green with a leathery texture and an entire margin."))
        plantList.add(Plant(R.drawable.image11, "Purple Passion", "Gynura aurantiaca, called purple passion or velvet plant, is a species of flowering plant in the daisy family Asteraceae. It is native to Southeast Asia but grown in many other places as a house plant. Gynura aurantiaca is an evergreen perennial growing to 30 cm (12 in) tall, the stems sometimes growing straight up but other times reclining against other objects, when stems can reach 2 m (6.6 ft). As a house plant, the long trailing vines are appropriate for a hanging pot or similar arrangement. Leaves, stems, and bracts are dark green, covered with soft purple hairs that impart a velvety feeling to the plant. One plant can produce 1-5 flower heads, each on its own flower stalk."))
        plantList.add(Plant(R.drawable.image12, "Red Valerian", "Centranthus ruber, the red valerian, is a popular garden plant grown for its ornamental flowers. It grows as a perennial plant, usually as a subshrub though it can take any form from a herbaceous plant to a shrub depending on conditions; the plants are usually woody at the base. The plant flowers profusely, and though the individual flowers are small (no more than 2 mm), the inflorescences are large and showy. The flowers are small in rounded clusters each with 5 fused petals and a spur. The most typical color is a brick red or purplish red, but colors include deep crimson, pale pink, and lavender."))
        plantList.add(Plant(R.drawable.image13, "Snow-in-Summer", "Cerastium tomentosum (snow-in-summer) is an herbaceous flowering plant and a member of the family Caryophyllaceae. It is generally distinguished from other species of its genus by tomentose or felty foliage. It is a low, spreading perennial native to alpine regions of Europe. It is an evergreen, creeping off-shoot, perennial, herbaceous plant that reaches heights of growth of 15 to 30 (rarely to 45) centimeters. It is overall densely hairy. The leaves are up to 30 millimetres long and linear to lanceolate, which are covered with silky, silvery, frizzy and entangled hairs, forming like whitish felting."))
        plantList.add(Plant(R.drawable.image14, "Spiderwort", "Tradescantia, also known as spiderwort is a genus 85 species of herbaceous perennial wildflowers in the family Commelinaceae, native to the Americas from southern Canada and northern Argentina. radescantia are herbaceous perennials and include both climbing and trailing species, reaching 30–60 centimetres (0.98–1.97 ft) in height. The leaves are long, thin and blade-like to lanceolate, from 3–45 cm long (1.2–17.7 in). The flowers can be white, pink, purple or blue, with three petals and six yellow anthers (or rarely, four petals and eight anthers). The sap is mucilaginous and clear"))
        plantList.add(Plant(R.drawable.image15, "Venus Fly Trap", "The Venus flytrap (Dionaea muscipula) is a carnivorous plant native to the temperate and subtropical wetlands of North Carolina and South Carolina, on the East Coast of the United States. The Venus flytrap is a small plant whose structure can be described as a rosette of four to seven leaves, which arise from a short subterranean stem that is actually a bulb-like object. Each stem reaches a maximum size of about three to ten centimeters, depending on the time of year; longer leaves with robust traps are usually formed after flowering. Flytraps that have more than seven leaves are colonies formed by rosettes that have divided beneath the ground."))
        plantList.add(Plant(R.drawable.image16, "Woodland Phlox", "Phlox divaricata, the wild blue phlox, woodland phlox, or wild sweet william, is a species of flowering plant in the family Polemoniaceae, native to forests and fields in eastern North America. Wild blue phlox is a semi-evergreen perennial growing 25–50 cm (10–20 in) tall with opposite, unstalked, hairy leaves 2.5–5 cm (1–2 in) in length and ovate-lanceolate in shape. Flowers appear in late spring and early summer. They are pleasantly fragrant and 2–4 cm (3⁄4–1+1⁄2 in) in diameter, with five petals fused at the base into a thin tube. The petals are a variety of pastel colors: blue-lavender, light purple, pink, or white. Flowers bloom March to May. It grows in moist, deciduous woods and bluffs."))


        plantAdapter = PlantAdapter(plantList)
        recyclerView.adapter = plantAdapter

        //Directs to plant description when clicked
        plantAdapter.onItemClick ={
            val intent = Intent(this, PlantActivity::class.java)
            intent.putExtra("plant", it)
            startActivity(intent)
        }
    }
}
