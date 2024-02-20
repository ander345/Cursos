using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace DesignPatternsAsp.Models.ViewModels
{
    public class FormBeerViewModel
    {
        [Required]
        [Display(Name = "Nombre")]
        public string Name { get; set; }
        [Required]
        [Display(Name = "Estilo")]
        public string Style { get; set; }
        [Display(Name = "Marca")]
        public Guid? BrandId { get; set; }
        [Display(Name = "Otra marca")]
        public string OtherBrand { get; set; }
    }
}
